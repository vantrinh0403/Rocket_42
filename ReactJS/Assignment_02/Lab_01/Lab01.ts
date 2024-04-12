class Department {

    private static counter: number = 0;

    private id: number;
    private name: string;

    public get getId() {
        return this.id;
    }

    public set setId(id:number) {
        this.id = id;
    }

    public get getName() {
        return this.name;
    }

    public set setName(name:string) {
        this.name = name;
    }

    constructor(name: string) {
        this.id = ++Department.counter;
        this.name = name;
    }

    public displayDetails() {
        console.log(`ID: ${this.getId}, Name: ${this.getName}`);
    }
}

class Position {

    private static counter: number = 0;

    private id: number;
    private name: string;

    public get getId() {
        return this.id;
    }

    public set setId(id:number) {
        this.id = id;
    }

    public get getName() {
        return this.name;
    }

    public set setName(name:string) {
        this.name = name;
    }

    constructor(name: string) {
        this.id = ++Position.counter;
        this.name = name;
    }

    public displayDetails() {
        console.log(`ID: ${this.getId}, Name: ${this.getName}`);
    }
}

class Account {

    private static counter: number = 0;

    private id: number;
    private email: string;
    private userName: string;
    private fullName: string;
    private department: Department;
    private position: Position;
    private createDate: Date;

    public get getId(): number {
        return this.id;
    }

    public set setId(id:number) {
        this.id = id;
    }

    public get getEmail(): string {
        return this.email;
    }

    public set getEmail(email:string){
        this.email = email;
    }

    public get getUsername(): string {
        return this.userName;
    }

    public set setUsername(userName:string) {
        this.userName = userName;
    }

    public get getFullName(): string {
        return this.fullName;
    }

    public set setFullName(fullName:string){
        this.fullName = fullName;
    }

    public get getDepartment(): Department {
        return this.department;
    }

    public set setDepartment(department:Department){
        this.department = department;
    }

    public get getPosition(): Position {
        return this.position;
    }

    public set setPosition(position:Position){
        this.position = position;
    }

    public get getCreateDate() {
        return this.createDate;
    }

    constructor(email: string, userName: string, fullName: string, department:Department, position: Position) {
        this.id = ++Account.counter;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.department = department;
        this.position = position;
        this.createDate = new Date();
    }

    public displayDetails(){
        console.log( `
        ID: ${this.id},
        Email: ${this.getEmail},
        FullName: ${this.getFullName}, 
        Department: ${this.getDepartment.getName}, 
        Position: ${this.getPosition.getName}`);
    }
}

class Manager {
    departments: Department[];
    positions: Position[];
    accounts: Account[];

    constructor() {
        this.departments = [];
        this.positions = [];
        this.accounts = [];
    }

    // Method to add an department
    addDepartment(department: Department) {
        this.departments.push(department);
    }

    // Method to remove an department
    removeDepartment(id: number) {
        this.departments = this.departments.filter(dept => dept.getId !== id);
    }

    // Method to display all department
    displayDepartments() {
        console.log("List of departments:");
        this.departments.forEach(dept => dept.displayDetails());
    }

    // Method to add an position
    addPosition(position: Position) {
        this.positions.push(position);
    }

    // Method to remove an position
    removePosition(id: number) {
        this.positions = this.positions.filter(pos => pos.getId !== id);
    }

    // Method to display all department
    displayPositions() {
        console.log("List of positions:");
        this.positions.forEach(pos => pos.displayDetails());
    }

    // Method to add an account
    addAccount(account: Account) {
        this.accounts.push(account);
    }

    // Method to remove an account
    removeAccount(id: number) {
        this.accounts = this.accounts.filter(acc => acc.getId !== id);
    }

    // Method to display all department
    displayAccounts() {
        console.log("List of accounts:");
        this.accounts.forEach(acc => acc.displayDetails());
    }
}

// Usage
const manager = new Manager();

// Add departments
let dept1 = new Department("Sale");
let dept2 = new Department("Marketing");
let dept3 = new Department("Bảo vệ");
let dept4 = new Department("Nhân sự");
manager.addDepartment(dept1);
manager.addDepartment(dept2);
manager.addDepartment(dept3);
manager.addDepartment(dept4);

// Add positions
let position1 = new Position("Dev");
let position2 = new Position("Test");
let position3 = new Position("PM");
let position4 = new Position("Scrum Master");
manager.addPosition(position1);
manager.addPosition(position2);
manager.addPosition(position3);
manager.addPosition(position4);

// Add accounts
manager.addAccount(new Account("vantrinh@gmail", "vantrinh", "Nguyen Van Trinh", dept4, position1));
manager.addAccount(new Account("laido@gmail", "laido", "Do Thi Lai", dept4, position3));
manager.addAccount(new Account("thanhnga@gmail", "thanhnga", "Nguyen Thi Thanh Nga", dept4, position2));



// Display employees
manager.displayDepartments();
manager.displayPositions();
manager.displayAccounts();


