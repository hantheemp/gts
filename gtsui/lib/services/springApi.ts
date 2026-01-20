import axios from 'axios';

const springApi = axios.create({
  baseURL: process.env.SPRING_API_URL,
  headers: {
    'Content-Type': 'application/json',
  },
  timeout: 10000,
});

springApi.interceptors.response.use(
  (res) => {
    if (res.data && 'resultData' in res.data) {
      return { ...res, data: res.data.resultData };
    }
    return res;
  },
  (err) => Promise.reject(err)
);

export default springApi;