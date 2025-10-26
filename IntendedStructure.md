gts/
│
├── app/
│   ├── favicon.ico
│   ├── globals.css
│   ├── layout.tsx
│   ├── page.tsx                  # Landing page (Welcome or Start Game)
│   │
│   ├── stage/
│   │   ├── listen/page.tsx       # Stage 1 – Listen
│   │   ├── artist/page.tsx       # Stage 2 – Artist Guess
│   │   ├── music/page.tsx        # Stage 3 – Music Guess
│   │   └── popularity/page.tsx   # Stage 4 – Popularity Guess
│   │
│   ├── results/page.tsx          # After all guesses → reveal
│   └── api/
│       ├── song/route.ts         # Fetch daily song
│       └── submit/route.ts       # Handle guesses
│
├── components/
│   │
│   ├── atoms/
│   │   ├── ButtonPrimary.tsx
│   │   ├── ButtonSecondary.tsx
│   │   ├── InputText.tsx
│   │   ├── InputNumber.tsx
│   │   ├── SelectField.tsx
│   │   ├── RadioOption.tsx
│   │   ├── ProgressBar.tsx
│   │   ├── StageHeading.tsx
│   │   └── BackgroundGrid.tsx
│   │
│   ├── molecules/
│   │   ├── AudioPlayer.tsx
│   │   ├── StageHeader.tsx
│   │   ├── StageProgress.tsx
│   │   ├── FormField.tsx
│   │   └── RadioGroup.tsx
│   │
│   ├── organisms/
│   │   ├── StageCard.tsx
│   │   ├── ArtistGuessForm.tsx
│   │   ├── MusicGuessForm.tsx
│   │   ├── PopularityGuessForm.tsx
│   │   └── ResultsCard.tsx
│   │
│   ├── layout/
│   │   ├── Navbar.tsx
│   │   └── Footer.tsx
│   │
│   └── ui/
│       ├── Card.tsx
│       └── Modal.tsx
│
├── lib/
│   ├── api.ts                    # Fetch helpers (song, submit)
│   ├── constants.ts              # Static lists (genres, moods, etc.)
│   ├── utils.ts                  # Formatters, validators
│   ├── types.ts                  # TypeScript interfaces
│   └── prisma.ts (optional)      # If you use Prisma / database
│
├── public/
│   ├── logo.svg
│   └── placeholder.jpg
│
├── styles/
│   └── daisyui-theme.css         # Custom DaisyUI theme overrides
│
├── postcss.config.mjs
├── tailwind.config.ts
├── next.config.ts
├── package.json
├── tsconfig.json
└── README.md