import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Photo } from '../photo/photo';
import { Subject } from 'rxjs';
import { debounceTime } from 'rxjs/operators';
import { PhotoService } from '../photo/photo.service';

@Component({
  selector: 'ap-photo-list',
  templateUrl: './photo-list.component.html',
  styleUrls: ['./photo-list.component.css']
})
export class PhotoListComponent implements OnInit, OnDestroy {

  photos: Photo[] = [];
  filter: string = '';
  debounce: Subject<string> = new Subject<string>();
  hasMore: boolean = true;
  currentPage: number = 1;
  username: string = '';

  constructor(
      private activatedRoute: ActivatedRoute,
      private photoService: PhotoService
    ){
  }
  
  ngOnInit(): void {
    this.username = this.activatedRoute.snapshot.params.username;
    this.photos = this.activatedRoute.snapshot.data.photos;
    this.debounce.pipe(debounceTime(300)).subscribe(filter => this.filter = filter);
  }
  
  ngOnDestroy(): void {
    this.debounce.unsubscribe();
  }

  load() {
    console.log("cliquei");
    this.photoService
        .listFromUserPaginated(this.username, ++this.currentPage)
        .subscribe(photos => {
            this.photos.push(...photos);
            // outra maneira: this.photos = this.photos.concat(photos)
            if(!photos.length) this.hasMore = false;
        });
}

}
