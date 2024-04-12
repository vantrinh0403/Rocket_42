import {CanBo, Gender} from './CanBo';


export class Congnhan extends CanBo {
    private level: number;


	constructor(fullName: string, age: number, gender: Gender, address: string, level: number) {
        super(fullName, age, gender, address);
		this.level = level;
	}


    /**
     * Getter level
     * @return {number}
     */
	public getLevel(): number {
		return this.level;
	}

    /**
     * Setter level
     * @param {number} value
     */
	public setLevel(value: number) {
		this.level = value;
	}

    public displayDetails(){
        super.displayDetails();
        console.log( ` Level: ${this.getLevel()} `);
    }
    
}
