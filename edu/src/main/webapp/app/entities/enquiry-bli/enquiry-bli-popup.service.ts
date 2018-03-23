import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { DatePipe } from '@angular/common';
import { EnquiryBli } from './enquiry-bli.model';
import { EnquiryBliService } from './enquiry-bli.service';

@Injectable()
export class EnquiryBliPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private datePipe: DatePipe,
        private modalService: NgbModal,
        private router: Router,
        private enquiryService: EnquiryBliService

    ) {
        this.ngbModalRef = null;
    }

    open(component: Component, id?: number | any): Promise<NgbModalRef> {
        return new Promise<NgbModalRef>((resolve, reject) => {
            const isOpen = this.ngbModalRef !== null;
            if (isOpen) {
                resolve(this.ngbModalRef);
            }

            if (id) {
                this.enquiryService.find(id)
                    .subscribe((enquiryResponse: HttpResponse<EnquiryBli>) => {
                        const enquiry: EnquiryBli = enquiryResponse.body;
                        enquiry.enquiryDate = this.datePipe
                            .transform(enquiry.enquiryDate, 'yyyy-MM-ddTHH:mm:ss');
                        this.ngbModalRef = this.enquiryModalRef(component, enquiry);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.enquiryModalRef(component, new EnquiryBli());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    enquiryModalRef(component: Component, enquiry: EnquiryBli): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.enquiry = enquiry;
        modalRef.result.then((result) => {
            this.router.navigate([{ outlets: { popup: null }}], { replaceUrl: true, queryParamsHandling: 'merge' });
            this.ngbModalRef = null;
        }, (reason) => {
            this.router.navigate([{ outlets: { popup: null }}], { replaceUrl: true, queryParamsHandling: 'merge' });
            this.ngbModalRef = null;
        });
        return modalRef;
    }
}
