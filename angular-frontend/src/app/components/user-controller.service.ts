import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root',
})
export class UserControllerService {
  private readonly _baseUrl = 'http://localhost:8081/api';
  private readonly _resourceUrl = "/v1/user/register"

  constructor(private httpClient: HttpClient) {
  }

  registerUser(username: String, password: String) {
    return this.httpClient.post(`${this._baseUrl}${this._resourceUrl}`, {
      username,
      password
    })
  }
}
