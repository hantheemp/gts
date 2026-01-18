export const API_BASE_URL = "https://localhost:8081/api/v1"; // will refactor for .env.

async function parseJSONResponse<T>(response: Response): Promise<T> {
  try {
    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }
    return response.json() as Promise<T>;
  } catch (error) {
    throw new Error(`Failed to parse JSON response: ${error}`);
  }
}
