### 参考文章
https://medium.com/frontend-fun/angular-unit-testing-jasmine-karma-step-by-step-e3376d110ab4

### Jasmine 
Jasmine is the test framework. It has many functionalities to allow us the write different tests. 
### Karma
Karma is a task runner for our tests. It has configuration file to set the startup file, the reporters, the testing framework, the browser and etc.
### How to do unit test in Angular 
run ```ng test```

### Example
```ts
import { ContactComponent } from './contact.component';

describe('ContactComponent', () => {
  let comp: ContactComponent;
  let fixture: ComponentFixture<ContactComponent>;
  let de: DebugElement;
  let el: HTMLElement;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [xxxComponent],
      imports: [xxxModules]
    }).compileComponents().then(() => {
      fixture = TestBed.createComponent(ContactComponent);
      comp = fixture.componentInstance; // ContactComponent test instance
      // query for the title <h1> by CSS element selector
      de = fixture.debugElement.query(By.css('form'));
      el = de.nativeElement;
    });
  }));

  it(`should call the onSubmit method`, async(() => {
    spyOn(comp, 'onSubmit');
    el = fixture.debugElement.query(By.css('button')).nativeElement;
    el.click();
    expect(comp.onSubmit).toHaveBeenCalled();
  }));

  it(`form should be valid`, async(() => {
    comp.contactForm.controls['email'].setValue('asd@asd.com');
    comp.contactForm.controls['name'].setValue('aada');
    comp.contactForm.controls['text'].setValue('text');
    expect(comp.contactForm.valid).toBeTruthy();
  }));
});
```