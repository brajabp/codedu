import { BaseEntity } from './../../shared';

export const enum AccountStatus {
    'PENDING',
    'SUBSCRIBED',
    'UNSUBSCRIBED'
}

export class EnrollBli implements BaseEntity {
    constructor(
        public id?: number,
        public accountStatus?: AccountStatus,
        public createDate?: any,
        public modDate?: any,
        public paymentIds?: BaseEntity[],
        public courseIdId?: number,
        public studentIdId?: number,
        public batchIdId?: number,
    ) {
    }
}
