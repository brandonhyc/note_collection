# Angular 基础笔记



### @Component
````js
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-servers',
  templateUrl: './servers.component.html',
  styleUrls: ['./servers.component.css']
})
export class ServersComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}

------------------------------------------

@Component({
  selector: 'app-servers',
  // selector: '.app-servers'  CLASS
  // selector: '[app-servers]', Attribute
  template: `<app-server></app-server>`,
  styles: [`
    h1 {
       color: blue; 
    }
  `]
})
export class ServersComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
````

### Property Binding [ ]
```html
<button [disabled]="!boolFlag" (click)="func()"></button>
```
### Two Way Binding [(ngModel)]
```html
<input [(ngModel)="serverName"]></input>

```


### String Interpolation {{ }}
```html
<p>{{ string }}</p>
```
