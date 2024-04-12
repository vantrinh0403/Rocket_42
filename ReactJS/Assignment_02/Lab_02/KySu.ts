import {CanBo, Gender} from './CanBo';


export class KySu extends CanBo {
    private training: string;


	constructor(fullName: string, age: number, gender: Gender, address: string, training: string) {
        super(fullName, age, gender, address);
		this.training = training;
	}



    /**
     * Getter training
     * @return {string}
     */
	public getTraining(): string {
		return this.training;
	}

    /**
     * Setter training
     * @param {string} value
     */
	public setTraining(value: string) {
		this.training = value;
	}


    public displayDetails(){
        super.displayDetails();
        console.log( `Tranining: ${this.getTraining()}`);
    }
    
}
