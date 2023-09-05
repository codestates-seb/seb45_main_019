import axios from 'axios';

const SERVER_URL =
  'http://ec2-13-209-48-235.ap-northeast-2.compute.amazonaws.com:8080';
// 'https://b0bf-14-36-94-78.ngrok-free.app';

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
