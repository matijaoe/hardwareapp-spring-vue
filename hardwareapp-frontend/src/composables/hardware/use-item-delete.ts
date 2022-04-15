import { deleteHardware } from "@/services/hardware";
import { useHardwareStore } from "@/stores/hardware";
import { set } from "@vueuse/core";

export const useItemDelete = () => {
  const store = useHardwareStore();

  const loading = ref(false);
  const isDeleted = ref(false);

  const deleteItem = async (code: string) => {
    set(loading, true);
    try {
      await deleteHardware(code);
      set(isDeleted, true);
    } catch (err) {
      console.error("Error deleting item", err);
      set(isDeleted, false);
    } finally {
      // TODO: remove forced delay after flexing the animation
      setTimeout(async () => {
        set(loading, false);
        await store.fetchHardware();
      }, 500);
    }
  };

  return {
    loading,
    isDeleted,
    deleteItem,
  };
};
