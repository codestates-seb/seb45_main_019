import { legacy_createStore as createStore, combineReducers } from 'redux';
import { testReducer } from './reducers';

export const store = createStore(
  combineReducers({
    testReducer
  })
);
