
export class CanBo {

    private static counter: number = 0;

    private id: number;
    private fullName: string;
    private age: number;
    private gender: Gender;
    private address: string;

    constructor(fullName: string, age: number, gender: Gender, address: string) {
        this.id = ++CanBo.counter;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }


    /**
     * Getter id
     * @return {number}
     */
	public getId(): number {
		return this.id;
	}

    /**
     * Getter fullName
     * @return {string}
     */
	public getFullName(): string {
		return this.fullName;
	}

    /**
     * Getter age
     * @return {number}
     */
	public getAge(): number {
		return this.age;
	}

    /**
     * Getter gender
     * @return {Gender}
     */
	public getGender(): Gender {
		return this.gender;
	}

    /**
     * Getter address
     * @return {string}
     */
	public getAddress(): string {
		return this.address;
	}

    /**
     * Setter id
     * @param {number} value
     */
	public setId(value: number) {
		this.id = value;
	}

    /**
     * Setter fullName
     * @param {string} value
     */
	public setFullName(value: string) {
		this.fullName = value;
	}

    /**
     * Setter age
     * @param {number} value
     */
	public setAge(value: number) {
		this.age = value;
	}

    /**
     * Setter gender
     * @param {Gender} value
     */
	public setGender(value: Gender) {
		this.gender = value;
	}

    /**
     * Setter address
     * @param {string} value
     */
	public setAddress(value: string) {
		this.address = value;
	}

    public displayDetails(){
        console.log( `
            ID: ${this.getId()},
            FullName: ${this.getFullName()}, 
            Age: ${this.getAge()}, 
            Gender: ${this.getGender()},
            Address: ${this.getAddress()}
        `);
    }
}



export enum Gender {
    MALE, FEMALE, OTHER
}

