export type Hardware = {
  name: string;
  code: string;
  price: number;
  type: HardwareType;
  availableCount: number;
};

export type HardwareDTO = Pick<Hardware, "code" | "name" | "price">;

export enum HardwareType {
  CPU,
  GPU,
  MBO,
  RAM,
  STORAGE,
  OTHER,
}
