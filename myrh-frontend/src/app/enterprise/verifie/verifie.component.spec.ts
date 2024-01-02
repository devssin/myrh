import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerifieComponent } from './verifie.component';

describe('VerifieComponent', () => {
  let component: VerifieComponent;
  let fixture: ComponentFixture<VerifieComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VerifieComponent]
    });
    fixture = TestBed.createComponent(VerifieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
