export type GenericError = Record<string, any> & {
  error: string;
  status: number;
  timestamp?: string;
  message?: string;
  path?: string;
};
