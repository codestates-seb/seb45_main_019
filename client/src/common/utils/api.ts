import axios from 'axios';

// const SERVER_URL = process.env.REACT_APP_API_URL;
const SERVER_URL = 'http://ec2-13-209-48-235.ap-northeast-2.compute.amazonaws.com:8080';

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
