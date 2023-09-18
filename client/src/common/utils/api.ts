import axios from 'axios';

const SERVER_URL = process.env.REACT_APP_API_URL;
// const SERVER_URL = 'https://abe8-14-36-94-78.ngrok-free.app';

const api = (
  uri: string,
  method?: 'get' | 'post' | 'patch' | 'delete',
  data?: object
) => {
  // const token = localStorage.getItem('token');
  const config = {
    method: method ? method : 'get',
    url: SERVER_URL + uri,
    headers: {
      'Content-Type': 'application/json'
      // Add more headers as needed
      // Authorization: token
    },
    data: data
  };

  return axios(config);
};

export default api;
