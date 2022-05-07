import { useHardwareFetch } from "@/composables/hardware/use-hardware-fetch";
import { deleteHardware } from "@/services/hardware";
import { set } from "@vueuse/core";

export const useItemDelete = () => {
  const loading = ref(false);
  const isDeleted = ref(false);

  const { fetchHardware } = useHardwareFetch();

  const deleteItem = async (code: string) => {
    set(loading, true);
    try {
      await deleteHardware(code);
      set(isDeleted, true);
      await fetchHardware();
    } catch (err) {
      console.error("Error deleting item", err);
      set(isDeleted, false);
    } finally {
      set(loading, false);
    }
  };

  return {
    loading,
    isDeleted,
    deleteItem,
  };
};
