<script setup lang="ts">
import { useItemDelete } from "@/composables/hardware/use-item-delete";
import type { HardwareDTO } from "@/models/hardware";
import { PhDesktopTower, PhX } from "phosphor-vue";

type Props = {
  item: HardwareDTO;
  selected?: boolean;
};

defineProps<Props>();

const { deleteItem, loading } = useItemDelete();
</script>

<template>
  <n-spin :show="loading">
    <li cursor="pointer" class="group">
      <n-card
        hoverable
        size="medium"
        border="hover:primary"
        :class="[{ '!border-primary bg-primary/10': selected }]"
      >
        <div w="full" flex="~ gap-4" justify="between">
          <div flex="~ gap-6" items="center">
            <ph-desktop-tower
              :size="42"
              text="primary"
              flex="shrink-0"
              weight="duotone"
            />
            <h4 text="lg">{{ item.name }}</h4>
          </div>
          <PopConfirmDelete @confirm="deleteItem(item.code)">
            <n-button
              class="visible"
              circle
              quaternary
              type="error"
              @click.stop=""
            >
              <template #icon>
                <ph-x weight="bold" />
              </template>
            </n-button>
          </PopConfirmDelete>
        </div>
      </n-card>
    </li>
  </n-spin>
</template>
