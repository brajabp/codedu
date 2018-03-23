import { BaseEntity } from './../../shared';

export class EnquiryBli implements BaseEntity {
    constructor(
        public id?: number,
        public enquiryDate?: any,
        public comment?: string,
        public phone?: string,
        public email?: string,
        public address?: string,
        public followUpIds?: BaseEntity[],
        public organizationIdId?: number,
    ) {
    }
}
