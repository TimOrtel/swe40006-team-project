import {Component, OnInit} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {NgForOf} from "@angular/common";
import {FormsModule} from "@angular/forms";


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, NgForOf, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'frontend';

  userMessage = '';

  messages: string[] = [];

  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    this.loadMessages()
  }

  loadMessages() {
    this.http.get<string[]>('/api/messages').subscribe(response => {
      this.messages = response
    })
  }

  sendMessage() {
    this.http.post('/api/messages/create', this.userMessage).subscribe(response => {
        // If the post is successful, add the new message to the list and clear the input field
        this.userMessage = '';
        this.loadMessages()
      }
    );
  }
}
