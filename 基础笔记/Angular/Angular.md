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

### @Input/output
```ts
------------------ hero-detail-component
import { Hero } from '../hero';
export class HeroDetailComponent implements OnInit {
  @Input() hero: Hero;
  @Output() deleteRequest = new EventEmitter<Hero>();
}
-- html
<div><span>id: </span>{{hero.id}}</div>
                           ↑↑↑↑
------------------ heros-component
-- html
<app-hero-detail [hero]="selectedHero"
                 (deleteRequest)="deleteHero($event)"
></app-hero-detail>
                    ↑↑↑↑
```
#### alternatives
```ts
@Component({
  inputs: ['hero'],
  outputs: ['deleteRequest'],
})
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

## Communication between components

### Parent -> Child 
1. #tag
```ts
--- parent
<child #child></child>
<button (click)="child.childFn()" class="btn btn-success">调用子组件方法</button>
--- child
public childFn():void{
    console.log("子组件的名字是>"+this.panelTitle);
}
```
2. @Input & @Output
parent -> child
```ts
--- parent
<child panelTitle="一个新的标题"></child>

--- child
@Input()
public panelTitle:string;
```
3. ViewChild Decorator

### Child -> Parent
1. @Input & @Output
```ts
--- child
@Output()
public follow = new EventEmitter<string>();
this.follow.emit("follow");

---parent
<child (follow)="doSomething()"></child>
```   

### w/o relationships
1. service
```ts
--- service
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Subject } from 'rxjs/Subject';

/**
 * 用来充当事件总线的 Service
 */
@Injectable()
export class EventBusService {
  public eventBus:Subject<string> = new Subject<string>();

  constructor() { }

}

--- component1
import { Component, OnInit } from '@angular/core';
import { EventBusService } from '../service/event-bus.service';

@Component({
  selector: 'child-1',
  templateUrl: './child-1.component.html',
  styleUrls: ['./child-1.component.css']
})
export class Child1Component implements OnInit {

  constructor(public eventBusService:EventBusService) { }

  ngOnInit() {
  }

  public triggerEventBus():void{
    this.eventBusService.eventBus.next("第一个组件触发的事件");
  }
}

--- component2

import { Component, OnInit } from '@angular/core';
import { EventBusService } from '../service/event-bus.service';

@Component({
  selector: 'child-2',
  templateUrl: './child-2.component.html',
  styleUrls: ['./child-2.component.css']
})
export class Child2Component implements OnInit {
  public events:Array<any>=[];

  constructor(public eventBusService:EventBusService) {

  }

  ngOnInit() {
    this.eventBusService.eventBus.subscribe((value)=>{
      this.events.push(value+"-"+new Date());
    });
  }
}

``` 

2. localStorage/cookie
```ts
--- from
public writeData():void{
    window.localStorage.setItem("json",JSON.stringify({name:'大漠穷秋',age:18}));
}

--- to
var json=window.localStorage.getItem("json");
// window.localStorage.removeItem("json");
var obj=JSON.parse(json);
console.log(obj.name);
console.log(obj.age);
```


# 面试题

### angularjs vs angular
1. js, ts
2. the architecture of angularjs is mvc, but angular's is mvvm. So the controller and $scope are replaced by components and directives

### $scope vs $rootScope
1. "$rootScope” is a parent object of all “$scope” angular objects created in a web page.
2. A property assigned with $scope cannot be used outside the controller in which it is defined whereas a property assigned with $rootScope can be used anywhere.


