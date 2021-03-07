import { TestBed } from '@angular/core/testing';

import { IsLogedGuard } from './is-loged.guard';

describe('IsLogedGuard', () => {
  let guard: IsLogedGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(IsLogedGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
