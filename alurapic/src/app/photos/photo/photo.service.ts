import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Photo } from './photo';

const API = "http://localhost:3000/photos";

@Injectable({ providedIn: 'root' })
export class PhotoService {

    constructor(private http: HttpClient){
        this.http = http;
    }

    listFromUser(username: string){
        return this.http
            .get<Photo[]>(API + '/' + username);
    }

    listFromUserPaginated(username: string, page: number) {
        console.log(username);
        const params = new HttpParams()
            .append('page', page.toString());

        return this.http
            .get<Photo[]>(API + '/' + username, { params: params });
    }

}