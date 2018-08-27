import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { MainComponent } from './components/main/main.component';
import { HeroComponent } from './components/hero/hero.component';

export const routes: Routes = [
    { path: '', redirectTo: '/main',pathMatch: 'full' },
    { path: 'main', component: MainComponent },
    { path: 'hero', component: HeroComponent },
    { path: '**', redirectTo: '/main'}
]

@NgModule({
    imports: [ RouterModule.forRoot(routes,{useHash:true}) ],
    exports: [ RouterModule ]
})

export class AppRoutingModule {}