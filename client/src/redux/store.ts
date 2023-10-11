import {
  configureStore,
  ThunkAction,
  Action,
  combineReducers
} from '@reduxjs/toolkit';
import userReducer from './slices/user';
import chapterReducer from './slices/chapter';
import {
  persistReducer,
  persistStore,
  FLUSH,
  REHYDRATE,
  PAUSE,
  PERSIST,
  PURGE,
  REGISTER
} from 'redux-persist';
import storage from 'redux-persist/lib/storage';

// Root 리듀서 생성
const rootReducer = combineReducers({
  user: userReducer,
  chapter: chapterReducer
});

// Redux 상태를 로컬 스토리지에 저장하는 구성
const persistConfig = {
  key: 'root', // 저장 키
  storage // 사용할 스토리지
};

// Root 리듀서에 persistConfig를 적용
const persistedReducer = persistReducer(persistConfig, rootReducer);

// Redux 스토어 생성
export const store = configureStore({
  reducer: persistedReducer, // 영속화된 리듀서를 사용
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware({
      serializableCheck: {
        ignoredActions: [FLUSH, REHYDRATE, PAUSE, PERSIST, PURGE, REGISTER]
      }
    })
});

export const persistor = persistStore(store);

// Infer the `RootState` and `AppDispatch` types from the store itself
export type RootState = ReturnType<typeof store.getState>;
// Inferred type: {posts: PostsState, comments: CommentsState, users: UsersState}
export type AppDispatch = typeof store.dispatch;
export type AppThunk<ReturnType = void> = ThunkAction<
  ReturnType,
  RootState,
  unknown,
  Action<string>
>;
