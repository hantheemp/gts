class ApiClient {
  private baseURL = '/api';

  async get<T>(url: string): Promise<T> {
    const response = await fetch(`${this.baseURL}${url}`);
    if (!response.ok) {
      const error = await response.json();
      throw new Error(error.error || 'Request failed');
    }
    return response.json();
  }

  async post<T>(url: string, data: any): Promise<T> {
    const response = await fetch(`${this.baseURL}${url}`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(data),
    });
    if (!response.ok) {
      const error = await response.json();
      throw new Error(error.error || 'Request failed');
    }
    return response.json();
  }

  async put<T>(url: string, data: any): Promise<T> {
    const response = await fetch(`${this.baseURL}${url}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(data),
    });
    if (!response.ok) {
      const error = await response.json();
      throw new Error(error.error || 'Request failed');
    }
    return response.json();
  }

  async delete<T = void>(url: string): Promise<T> {
    const response = await fetch(`${this.baseURL}${url}`, {
      method: 'DELETE',
    });
    if (!response.ok) {
      const error = await response.json();
      throw new Error(error.error || 'Request failed');
    }
    return response.status === 204 ? (undefined as T) : response.json();
  }
}

export const apiClient = new ApiClient();