import { BaseEntity } from './../../shared';

export class FollowUpBli implements BaseEntity {
    constructor(
        public id?: number,
        public followUpDate?: any,
        public comment?: string,
        public enquiryIdId?: number,
        public employeeIdId?: number,
    ) {
    }
}
