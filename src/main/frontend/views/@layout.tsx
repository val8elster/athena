import { createMenuItems, useViewConfig } from '@vaadin/hilla-file-router/runtime.js';
import { effect, signal } from '@vaadin/hilla-react-signals';
import { AppLayout, Icon } from '@vaadin/react-components';
import { Suspense, useEffect } from 'react';
import { NavLink, Outlet } from 'react-router-dom';

const defaultTitle = document.title;
const documentTitleSignal = signal('');
effect(() => {
  document.title = documentTitleSignal.value;
});

// Publish for Vaadin to use
(window as any).Vaadin.documentTitleSignal = documentTitleSignal;

export default function MainLayout() {
  const currentTitle = useViewConfig()?.title ?? defaultTitle;

  useEffect(() => {
    documentTitleSignal.value = currentTitle;
  });

  return (
    <AppLayout>
      <header className="box-border flex flex-col w-full" slot="navbar">
        <div className="flex items-center px-l">
          <h1 className="my-m me-auto text-l">My App</h1>
        </div>
        <nav className="flex overflow-auto px-m py-xs">
          <ul className="flex gap-s list-none m-0 p-0">
            {createMenuItems().map(({ to, title, icon }) => (
              <li key={'li' + to}>
                <NavLink className="flex gap-xs h-m items-center px-s text-body" to={to} key={to}>
                  {icon ? <Icon src={icon} key={'icon' + to}></Icon> : <></>}
                  <span className="font-medium text-m whitespace-nowrap" key={'span' + to}>
                    {title}
                  </span>
                </NavLink>
              </li>
            ))}
          </ul>
        </nav>
      </header>

      <h1 slot="navbar" className="text-l m-0">
        {documentTitleSignal}
      </h1>

      <Suspense>
        <Outlet />
      </Suspense>
    </AppLayout>
  );
}
