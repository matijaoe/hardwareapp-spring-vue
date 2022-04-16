import {
  defineConfig,
  presetAttributify,
  presetUno,
  transformerVariantGroup,
} from "unocss";

export default defineConfig({
  shortcuts: [],
  presets: [presetUno({}), presetAttributify({})],
  theme: {
    colors: {
      primary: "#63e2b7",
      background: {
        dark: "#101014",
      },
    },
    fontFamily: {
      sans: ["Ubuntu", "ui-system"],
      mono: ["Roboto Mono", "ui-mono"],
      display: ["Faster One", "Roboto Mono", "ui-mono"],
    },
  },
  transformers: [transformerVariantGroup()],
});
