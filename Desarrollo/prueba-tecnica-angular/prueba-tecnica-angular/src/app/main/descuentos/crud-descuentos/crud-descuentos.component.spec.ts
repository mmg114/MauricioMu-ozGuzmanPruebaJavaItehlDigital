import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrudDescuentosComponent } from './crud-descuentos.component';

describe('CrudDescuentosComponent', () => {
  let component: CrudDescuentosComponent;
  let fixture: ComponentFixture<CrudDescuentosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrudDescuentosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrudDescuentosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
