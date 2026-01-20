export interface SpringAPIResponse<T> {
  status: string;
  resultCode: number;
  resultMessage: string;
  resultData: T;
}
