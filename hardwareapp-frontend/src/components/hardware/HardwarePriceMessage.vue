<script setup lang="ts">
import { PhInfo } from "phosphor-vue";

type Props = {
  price: number;
};

const props = defineProps<Props>();

const message = computed(() => {
  let msg = "";
  if (props.price < 200) {
    msg = "Ovaj hardver se ne može kupiti na rate.";
  } else if (props.price < 500) {
    msg = "Ovaj hardver se može kupiti na 6 rata.";
  } else if (props.price < 900) {
    msg = "Ovaj hardver se može kupiti na 12 rata.";
  } else {
    msg = "Ovaj hardver se može kupiti na 24 rate.";
  }
  return msg;
});
</script>

<template>
  <NAlert title="Obročna uplata" type="info" h="full" weight="fill">
    <template #icon>
      <ph-info weight="fill" />
    </template>
    {{ message }}
  </NAlert>
</template>

<style lang="scss" scoped></style>
