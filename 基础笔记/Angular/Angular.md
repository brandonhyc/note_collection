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
#### 1. #tag
```ts
--- parent
<child #child></child>
<button (click)="child.childFn()" class="btn btn-success">调用子组件方法</button>
--- child
public childFn():void{
    console.log("子组件的名字是>" + this.panelTitle);
}
```
#### 2. @Input & @Output
parent -> child
```ts
--- parent
<child [panelTitle]="一个新的标题"></child>

--- child
@Input()
public panelTitle:string;
```
#### 3. ViewChild Decorator

### Child -> Parent
#### 1. @Input & @Output
```ts
--- child
@Output()
public follow = new EventEmitter<string>();
this.follow.emit("follow");

---parent
<child (follow)="doSomething()"></child>
```   

### w/o relationships
#### 1. service
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

#### 2. localStorage/cookie
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

  | AngularJS | Angular |
  |---- | ---------
  | It is based on MVC architecture  | This is based on Service/Controller |
  | This uses use JavaScript to build the application| Introduced the typescript to write the application |
  | Based on controllers concept| This is a component based UI approach|
  | Not a mobile friendly framework| Developed considering mobile platform|
  | Difficulty in SEO friendly application development| Ease to create SEO friendly applications|
  
### $scope vs $rootScope
1. "$rootScope” is a parent object of all “$scope” angular objects created in a web page.
2. A property assigned with $scope cannot be used outside the controller in which it is defined whereas a property assigned with $rootScope can be used anywhere.


### What are the differences between Component and Directive?

  In a short note, A component(@component) is a directive-with-a-template.

  Some of the major differences are mentioned in a tabular form

  | Component | Directive |
  |---- | ---------
  | Components are typically used to create UI widgets| Directive is used to add behavior to an existing DOM element |
  | Component is used to break up the application into smaller components| Directive is use to design re-usable components|
  | @View decorator or templateurl/template are mandatory | Directive doesn't use View|


### What is a template?
  A template is a HTML view where you can display data by binding controls to properties of an Angular component.
### What is a module?

  You can think of modules like packages or bundles containing the required code for a specific use case, it includes components and services. Modules are logical boundaries in your application and the application is divided into separate modules to separate the functionality of your application.
  
  ```typescript
  import { NgModule }      from '@angular/core';
  import { BrowserModule } from '@angular/platform-browser';
  import { AppComponent }  from './app.component';

  @NgModule ({
      imports:      [ BrowserModule ],
      declarations: [ AppComponent ],
      bootstrap:    [ AppComponent ]
  })
  export class AppModule { }
  ```
  1. The imports option is used to import other dependent modules. 
  2. The declarations option is used to define components in the respective module
  3. The bootstrap option tells Angular which Component to bootstrap in the application

### What are lifecycle hooks available?
  Each component will go through a whole lifecyle of key life moments from initiation to destruction.
  Angular offers lifecycle hooks that provide visibility into these key life moments
  

  The description of each lifecycle method is as below,
  1. **ngOnChanges:** When the value of a data bound property changes, then this method is called.
  2. **ngOnInit:** This is called whenever the initialization of the directive/component after Angular first displays the data-bound properties happens.
  3. **ngDoCheck:** This is for the detection and to act on changes that Angular can't or won't detect on its own.
  4. **ngAfterContentInit:** This is called in response after Angular projects external content into the component's view.
  5. **ngAfterContentChecked:** This is called in response after Angular checks the content projected into the component.
  6. **ngAfterViewInit:** This is called in response after Angular initializes the component's views and child views.
  7. **ngAfterViewChecked:** This is called in response after Angular checks the component's views and child views.
  8. **ngOnDestroy:** This is the cleanup phase just before Angular destroys the directive/component.


### Data Binding
Angular defined a way to have communications between component and DOM for data flowing.
Component -> DOM: Interpolation, Property binding: [property]=”value”
DOM -> Component: Event binding: (event)=”function”
Two-way binding: Two-way data binding: [(ngModel)]=”value”

### Meta Data
Metadata is used to decorate a class so that it can configure the expected behavior of the class. The metadata is represented by decorators

### Constructor vs. ngOnInit
In TypeScript, constructor will be called immediately when initializing a class. ngOnInit is in Angular, it means the key lifecycle moment of initialization of component. So, you will run into a problem if you assume the data is available via binding from parent component, and you put into constructor, it goes wrong when the data not yet exists.

### What is a service?
Angular services are singleton objects which get instantiated only once during the lifetime of an application. They contain methods that maintain data and is used for providing a common functionality for between modules. 

### What is dependency injection in Angular?
Dependency injection (DI), is an application design pattern. It means a class will use dependencies from external sources rather than creating them by itself. Angular comes with its own dependency injection framework for resolving dependencies. So you can have your services depend on other services throughout your application.

### ngIf 
In the view, some components are conditional. Use ngIf to control inserting or removing elements based on a condition.

### What are pipes? Give me an example.
A pipe takes in data as input and transforms it to a desired output. 
```ts
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({name: 'capitalize'})
export class CapitalizePipe implements PipeTransform {
  transform(value: string, args: string[]): any {
    if (!value) return value;

    return value.replace(/\w\S*/g, function(txt) {
        return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();
    });
  }
}
```

### What are some differences between Angular 2 and 4?
Just to name a few:
Improvements in AOT, allowing the "else" clause in ngIf, support for TypeScript 2.1, breaking out the animations package

## Optimization

### Using TrackBy
As a result, Angular needs to remove all the DOM elements associated with the data and create them again. This can mean a lot of DOM manipulations, especially in the case of a big collection. And, as we know, DOM manipulations are expensive.

### Avoid Computing Values (complex task) in the Template

### Disable Change Detection
```ts
@Component({
  selector: 'giant-list',
  template: `
    <li *ngFor="let d of dataProvider.data">Data {{d}}</li>
  `,
})
class GiantList {
  constructor(private ref: ChangeDetectorRef, private dataProvider: DataProvider) {
    ref.detach();
    setInterval(() => {
      this.ref.detectChanges();
    }, 5000);
  }
}
```


### What is lazy loading

Lazy loading is technique that defers loading of non-critical resources at page load time. Instead, these non-critical resources are loaded at the moment of need. 
```ts
--- app-routing.module.ts
const routes: Routes = [
  {
    path: "posts",
    loadChildren: "../app/posts/posts.module#PostsModule"
  }
  ...]

  @NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
https://codeburst.io/how-to-implement-lazy-loading-in-angular-6-419491102591
```


