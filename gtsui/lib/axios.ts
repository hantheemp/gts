import axios, { AxiosResponse } from "axios";

const baseURL = process.env.NEXT_PUBLIC_SPRING_API_URL;

const axiosInstance = axios.create({
  baseURL,
  withCredentials: true,
  headers: {
    "Content-Type": "application/json",
  },
  timeout: 10000,
});

axiosInstance.interceptors.response.use(
  <T = any>(res: AxiosResponse<any>): T => {
    const payload = res.data;

    if (payload && typeof payload === "object" && "data" in payload) {
      return payload.data as T;
    }

    return payload as T;
  },
  (err) => {
    const status = err.response?.status;
    const message = err.response?.data?.message || err.message;
    return Promise.reject({ status, message, details: err.response?.data });
  },
);

export const api = {
  get: <T>(url: string, config?: any) =>
    axiosInstance.get<T>(url, config) as Promise<T>,
  post: <T>(url: string, data?: any, config?: any) =>
    axiosInstance.post<T>(url, data, config) as Promise<T>,
  put: <T>(url: string, data?: any, config?: any) =>
    axiosInstance.put<T>(url, data, config) as Promise<T>,
  delete: <T = void>(url: string, config?: any) =>
    axiosInstance.delete<T>(url, config) as Promise<T>,
};
