export const handleError = (err: any) => {
  console.error("Error fetching data", err);
  return null;
};

export const parseData = (res: Response) => res.json();
