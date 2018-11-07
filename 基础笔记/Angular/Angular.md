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
### Style Property [ngStyle] / [style.color]
```html
<p [ngStyle]="{ 'background-color': getColor()}"></p>
<button [style.color]="isSpecial ? 'red' : 'green'">
```
### Class Property [ngClass] / [class.special]
```html
<p [ngClass]="{ btnClicked: true}"></p>
<div [class.special]="isSpecial">Special</div>
```
### Template statements ( )
```html
<button (click)="deleteHero()">Delete hero</button>
```
#### 坑
Prohibited Expressions: 
new
++ 和 --
操作并赋值，例如 += 和 -=
位操作符 | 和 &
模板语句不能引用全局命名空间的任何东西。比如不能引用 window 或 document，也不能调用 console.log 或 Math.max。
但允许: 于它支持基本赋值 (=) 和表达式链 (; 和 ,)。


### Two Way Binding [(ngModel)]
```html
<input [(ngModel)="serverName"]></input>

```

## Template Syntax {{ }}
### String Interpolation {{ }}
```html
<p>{{ string }}</p>
```
### 常见坑
模板变量是最优先的，其次是指令的上下文变量，最后是组件的成员。

模板表达式不能引用全局命名空间中的任何东西，比如 window 或 document。它们也不能调用 console.log 或 Math.max。 它们只能引用表达式上下文中的成员。

Prohibited Expressions: 
* 赋值 (=, +=, -=, ...)
* new 运算符
* 使用 ; 或 , 的链式表达式
* 自增和自减运算符：++ 和 --

# Directives
### *ngIf="" 
```html
<p *ngIf="flag; 
    else temp">Hello
</p>
<ng-template #temp>
  <p>Hi!</p>
</ng-template>
```

### *ngFor="let server of servers; let i=index"
```html
<p *ngFor="let server of servers">Hello</p>
```
### ngfor trackBy
This is for the purpose of improvement
```ts
trackByHeroes(index: number, hero: Hero): number { return hero.id; }
```
```html
<div *ngFor="let hero of heroes; trackBy: trackByHeroes">
  ({{hero.id}}) {{hero.name}}
</div> 
```

### Template reference variables ( #var )

### @Input
```ts
------------------ hero-detail-component
import { Hero } from '../hero';
export class HeroDetailComponent implements OnInit {
  @Input() hero: Hero;
}
-- html
<div><span>id: </span>{{hero.id}}</div>
                           ↑↑↑↑
------------------ heros-component
-- html
<app-hero-detail [hero]="selectedHero"></app-hero-detail>
                    ↑↑↑↑
```

# Routes

```ts
-------------------- app-routing.module.ts
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from '../dashboard/dashboard.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'detail/:id', component: HeroDetailComponent }
]
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ]
})

```
```html
------------------ Dashboard.html
<a routerLink="/detail/{{ hero.id }}">

------------------- app.module.html
<router-outlet></router-outlet>
```



