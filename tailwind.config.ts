import type { Config } from "tailwindcss";

const config: Config = {
  darkMode: "class",
  content: [
    "./pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./components/**/*.{js,ts,jsx,tsx,mdx}",
    "./app/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  theme: {
    extend: {
      colors: {
        primary: "#7f13ec",
        "background-light": "#f7f6f8",
        "background-dark": "#10141C",
        "card-dark": "#1E1E1E",
        accent: "#00FFFF",
        purple: {
          neon: "#9D00FF",
        },
        cyan: {
          neon: "#00FFFF",
        },
      },
      fontFamily: {
        display: ["Space Grotesk", "sans-serif"],
      },
      borderRadius: {
        DEFAULT: "1rem",
        lg: "2rem",
        xl: "3rem",
        full: "9999px",
      },
      boxShadow: {
        'glow-accent': '0 0 15px 5px rgba(0, 255, 255, 0.3), 0 0 25px 10px rgba(0, 255, 255, 0.2)',
        'glow-primary': '0 0 15px 5px rgba(127, 19, 236, 0.4), 0 0 25px 10px rgba(127, 19, 236, 0.3)',
      },
      animation: {
        'pulse-glow': 'pulse-glow 3s infinite ease-in-out',
        'neon-glow': 'neon-glow 2s ease-in-out infinite alternate',
        'grid-animation': 'grid-animation 10s linear infinite',
      },
      keyframes: {
        'pulse-glow': {
          '0%, 100%': {
            boxShadow: '0 0 15px 5px rgba(0, 255, 255, 0.3), 0 0 25px 10px rgba(0, 255, 255, 0.2)',
          },
          '50%': {
            boxShadow: '0 0 20px 8px rgba(0, 255, 255, 0.4), 0 0 30px 15px rgba(0, 255, 255, 0.3)',
          },
        },
        'neon-glow': {
          '0%, 100%': {
            boxShadow: '0 0 5px #7f13ec, 0 0 10px #7f13ec, 0 0 20px #7f13ec, 0 0 40px #7f13ec',
          },
          '50%': {
            boxShadow: '0 0 10px #7f13ec, 0 0 20px #7f13ec, 0 0 40px #7f13ec, 0 0 80px #7f13ec',
          },
        },
        'grid-animation': {
          from: {
            backgroundPosition: '0 0',
          },
          to: {
            backgroundPosition: '50px 50px',
          },
        },
      },
    },
  },
  plugins: [require("@tailwindcss/forms")],
};

export default config;