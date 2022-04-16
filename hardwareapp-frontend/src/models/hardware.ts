export type Hardware = {
  name: string;
  code: string;
  price: number;
  type: HardwareType;
  availableCount: number;
};

export type HardwareCreate = {
  name: string;
  code: string;
  price: number | null;
  type: HardwareType | null;
  availableCount: number | null;
};

export type HardwareDTO = Pick<Hardware, "code" | "name" | "price">;

export enum HardwareType {
  CPU = "CPU",
  GPU = "GPU",
  MBO = "MBO",
  RAM = "RAM",
  STORAGE = "STORAGE",
  OTHER = "OTHER",
}
