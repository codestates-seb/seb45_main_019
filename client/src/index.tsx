import ReactDOM from 'react-dom/client';
import App from './App';
import { BrowserRouter } from 'react-router-dom';
import { persistor, store } from './redux/store';
import { GlobalStyle } from './style/Global.styled';
import { Provider } from 'react-redux';
import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import { createTheme, ThemeProvider } from '@mui/material';
import { PersistGate } from 'redux-persist/integration/react';

const queryClient = new QueryClient({
  defaultOptions: {
    queries: {
      retry: 1,
      retryDelay: 0,
      staleTime: 5 * 60 * 1000,
      refetchOnWindowFocus: false
    },
    mutations: {
      retry: 1,
      retryDelay: 0
    }
  }
});
const defaultTheme = createTheme({
  components: {
    MuiFormControlLabel: {
      styleOverrides: {
        label: {
          fontSize: 14
        }
      }
    }
  },
  palette: {
    primary: {
      main: '#3290ca'
    },
    secondary: {
      main: '#01579b'
    },
    success: {
      main: '#27ae60'
    },
    error: {
      main: '#e74c3c'
    }
  }
});
console.log(defaultTheme);

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <BrowserRouter>
    <ThemeProvider theme={defaultTheme}>
      <GlobalStyle />
      <QueryClientProvider client={queryClient}>
        <Provider store={store}>
          <PersistGate loading={null} persistor={persistor}>
            <App />
          </PersistGate>
        </Provider>
      </QueryClientProvider>
    </ThemeProvider>
  </BrowserRouter>
);
