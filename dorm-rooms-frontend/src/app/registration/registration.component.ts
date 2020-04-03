import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import { Router } from '@angular/router';


@Component({
    selector: 'app-registration',
    templateUrl: './registration.component.html',
    styleUrls: ['./registration.component.css','../css/forms.css', '../css/common.css']
})
export class RegistrationComponent implements OnInit{

    private url: string;
    private token: string;

    constructor(private router: Router) {}

    ngOnInit():void{
        this.getUrl();
    }

    getUrl(): void
    {
        this.url = this.router.url;
        const index = this.url.indexOf("=") + 1;
        //this.token = this.router.
        console.log(this.router.getCurrentNavigation());
    }

}