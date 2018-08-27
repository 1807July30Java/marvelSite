import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavvybarComponent } from './navvybar.component';

describe('NavvybarComponent', () => {
  let component: NavvybarComponent;
  let fixture: ComponentFixture<NavvybarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavvybarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavvybarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
