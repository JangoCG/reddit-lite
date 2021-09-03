import {Component, OnInit} from '@angular/core';
import {UserControllerService} from "../user-controller.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  constructor(private userControllerService: UserControllerService) {
  }

  ngOnInit(): void {
  }

  registerUser(e: Event) {
    e.preventDefault();
    console.log("inside function")
    this.userControllerService.registerUser("aaaa", "bbb").subscribe();
  }
}
