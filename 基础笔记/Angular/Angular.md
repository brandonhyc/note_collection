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
### Style Property [ngStyle]
```html
<p [ngStyle]="{ 'background-color': getColor()}"></p>
```
### Class Property [ngClass]
```html
<p [ngClass]="{ btnClicked: true}"></p>
```

### Two Way Binding [(ngModel)]
```html
<input [(ngModel)="serverName"]></input>

```

### String Interpolation {{ }}
```html
<p>{{ string }}</p>
```

### Directive *ngIf="" 
```html
<p *ngIf="flag; 
    else temp">Hello</p>
<ng-template #temp>
  <p>Hi!</p>
</ng-template>
```

### *ngFor="let server of servers"
```html
<p *ngFor="let server of servers">Hello</p>
```

### @Input
```ts
------------------ hero-detail-component
import { Hero } from '../hero';
export class HeroDetailComponent implements OnInit {
  @Input() hero: Hero;
}
// <div><span>id: </span>{{hero.id}}</div>
                           ↑↑↑↑
------------------ heros-component
//<app-hero-detail [hero]="selectedHero"></app-hero-detail>
                    ↑↑↑↑
```

