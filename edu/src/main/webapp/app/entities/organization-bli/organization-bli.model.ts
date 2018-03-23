import { BaseEntity } from './../../shared';

export const enum Status {
    'ACTIVE',
    'INACTIVE'
}

export const enum AccountStatus {
    'PENDING',
    'SUBSCRIBED',
    'UNSUBSCRIBED'
}

export class OrganizationBli implements BaseEntity {
    constructor(
        public id?: number,
        public name?: string,
        public status?: Status,
        public accountStatus?: AccountStatus,
        public createDate?: any,
        public modDate?: any,
        public divisionIds?: BaseEntity[],
        public paymentIds?: BaseEntity[],
        public enquiryIds?: BaseEntity[],
        public courseIds?: BaseEntity[],
        public studentIds?: BaseEntity[],
        public employeeIds?: BaseEntity[],
    ) {
    }
}
