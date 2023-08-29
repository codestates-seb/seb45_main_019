import ReactDOM from 'react-dom/client';
import App from './App';
import { BrowserRouter } from 'react-router-dom';
import { store } from './redux';
// import { GlobalStyle } from './style/Global.styled';
import { Provider } from 'react-redux';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <BrowserRouter>
    {/* <GlobalStyle /> */}
    <Provider store={store}>
      <App />
    </Provider>
  </BrowserRouter>
);
