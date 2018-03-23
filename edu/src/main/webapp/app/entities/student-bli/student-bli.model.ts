import { BaseEntity } from './../../shared';

export const enum Status {
    'ACTIVE',
    'INACTIVE'
}

export class StudentBli implements BaseEntity {
    constructor(
        public id?: number,
        public name?: string,
        public status?: Status,
        public createDate?: any,
        public modDate?: any,
        public durationYear?: number,
        public durationMonth?: number,
        public durationDay?: number,
        public enrollIds?: BaseEntity[],
        public batchIds?: BaseEntity[],
        public organizationIdId?: number,
    ) {
    }
}
