import {CanBo, Gender} from './CanBo';
import {Congnhan} from './Congnhan';
import { KySu } from './KySu';
import { NhanVien } from './NhanVien';

class Manager {
    canbos: CanBo[];
    constructor() {
        this.canbos = [];
    }

    addCanbo(canbo: CanBo) {
        this.canbos.push(canbo);
    }

    // Method to add an cong nhan
    addCongnhan(congNhan: Congnhan) {
        this.canbos.push(congNhan);
    }

    addKySu(kySu: KySu) {
        this.canbos.push(kySu);
    }

    addNhanvien(nhanVien: NhanVien) {
        this.canbos.push(nhanVien);
    }

    displayCanBos() {
        console.log("List of canbo:");
        this.canbos.forEach(canbo => canbo.displayDetails());
    }

}


// Usage
const manager = new Manager();

// Add departments
let cb1 = new CanBo("Nguyen Van Trinh", 24, Gender.FEMALE, "Quang Binh");
let cb2 = new Congnhan("Nguyen Van A", 24, Gender.FEMALE, "Quang Binh", 1);
let cb3 = new KySu("Nguyen Van B", 24, Gender.FEMALE, "Quang Binh", "Thiet ke");
let cb4 = new NhanVien("Nguyen Thi C", 24, Gender.MALE, "Quang Binh", "Ke toan");
manager.addCanbo(cb1);
manager.addCongnhan(cb2);
manager.addKySu(cb3);
manager.addNhanvien(cb4);

manager.displayCanBos();