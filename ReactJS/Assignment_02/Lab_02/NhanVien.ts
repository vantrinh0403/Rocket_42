import {CanBo, Gender} from './CanBo';


export class NhanVien extends CanBo {
    private job: string;


	constructor(fullName: string, age: number, gender: Gender, address: string, job: string) {
        super(fullName, age, gender, address);
		this.job = job;
	}



    /**
     * Getter job
     * @return {string}
     */
	public getJob(): string {
		return this.job;
	}

    /**
     * Setter job
     * @param {string} value
     */
	public setJob(value: string) {
		this.job = value;
	}


    public displayDetails(){
        super.displayDetails();
        console.log( `Job: ${this.getJob()} `);
    }
    
}
