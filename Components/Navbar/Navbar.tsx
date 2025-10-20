"use client";

import { gameModes, utilityLinks } from "./data";

export default function Navbar() {
  const utility = utilityLinks;
  const game = gameModes;

  return (
    <div className="navbar bg-base-100 shadow-sm">
      <div className="flex-1">
        <a className="btn btn-ghost text-2xl">Guess the Song!</a>
      </div>
      <div className="flex-none">
        <ul className="menu menu-horizontal px-1">
          {utility.map((link) => (
            <li key={link.name}>
              <a href={link.url} target="_blank" rel="noopener noreferrer">
                {link.name}
              </a>
            </li>
          ))}
          <li>
            <details>
              <summary>Game Modes</summary>
              <ul className="bg-base-100 rounded-t-none p-2">
                {game.map((mode) => (
                  <li key={mode.name}>
                    <a href={mode.url}>{mode.name}</a>
                  </li>
                ))}
              </ul>
            </details>
          </li>
        </ul>
      </div>
    </div>
  );
}
