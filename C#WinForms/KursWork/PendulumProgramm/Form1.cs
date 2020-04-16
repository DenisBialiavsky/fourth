using System;
using System.Windows.Forms;
using Library;


namespace SingleThread
{
    public class Form1 : Form
    {
        private Pendulum Pend;
        private Drawer Drawer;
        private ISaver Saver;

        private PictureBox pictureBox1;
        private Button button1;
        private TextBox textBox1;
        private TextBox textBox2;
        private TextBox textBox3;
        private Label label1;
        private Label label2;
        private Label label3;
        private MenuStrip menuStrip1;
        private ToolStripMenuItem helpToolStripMenuItem;
        private ToolStripMenuItem userManualToolStripMenuItem;
        private Button button2;
        private Button button3;
        private Button button4;
        private Button button5;
        private ToolStripMenuItem aboutToolStripMenuItem;
        private Label label4;
        private Label label5;
        private Label label6;
        private Label label7;
        private RichTextBox richTextBox1;
        private Button button6;


        public Form1()
        {
            pictureBox1 = new PictureBox();
            button1 = new Button();
            textBox1 = new TextBox();
            textBox2 = new TextBox();
            textBox3 = new TextBox();
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            menuStrip1 = new MenuStrip();
            helpToolStripMenuItem = new ToolStripMenuItem();
            userManualToolStripMenuItem = new ToolStripMenuItem();
            aboutToolStripMenuItem = new ToolStripMenuItem();
            button2 = new Button();
            button3 = new Button();
            button4 = new Button();
            button5 = new Button();
            button6 = new Button();
            label4 = new Label();
            label5 = new Label();
            label6 = new Label();
            label7 = new Label();
            richTextBox1 = new RichTextBox();

            MaximizeBox = false;
            ShowIcon = false;
            Name = "Form1";
            Text = "Pendulum model";
            Load += new EventHandler(Form1_Load);
            SuspendLayout();
            ResumeLayout(false);
            PerformLayout();
            AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            ClientSize = new System.Drawing.Size(1095, 477);
            MainMenuStrip = menuStrip1;
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            float l, a,g, maxAlpha;
            while (true)
            {
                l = float.Parse(textBox1?.Text); a = float.Parse(textBox2?.Text);
                g = float.Parse(textBox3?.Text); maxAlpha = (float)Math.Asin(a / (2 * l));
                if (g > 0 && l*1.3 > a && l>0 && a > 0)
                {
                    break;
                }
                else
                {
                    richTextBox1.AppendText("The initial data is wrong!\nTry again.\n");
                    richTextBox1.ScrollToCaret();
                    return;
                }
            }
            PendulumBuilder builder;
            if (maxAlpha <= 0.0524)
            {
                builder = new Pendulum3DegBuilder();
            }
            else
            {//question
                builder = maxAlpha <= 1 ? new Pendulum60DegBuilder() : (PendulumBuilder)new Pendulum90DegBuilder();
            }
            PendulumBuildManager manager = new PendulumBuildManager(builder);
            Pend = manager.Produce(l, a, g);
            label5.Text = Math.Round(Pend.T, 4).ToString();
            Drawer?.Tmr?.Stop();
            Drawer = new Drawer(Pend, pictureBox1, label7);
            Processor.Process(Pend, pictureBox1);
            Drawer.Draw();
            button2.Enabled = true;
            button3.Enabled = true;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            richTextBox1.AppendText("WORD saving is in process...\n");
            Saver = new WordSaver();
            Saver.Done += (s) =>
            {
                richTextBox1.AppendText(s);
            };
            Saver.SaveAsync(Pend);
        }

        private void button3_Click(object sender, EventArgs e)
        {
            richTextBox1.AppendText("EXCEL saving is in process...\n");
            Saver = new ExcelSaver();
            Saver.Done += (s) =>
            {
                richTextBox1.AppendText(s);
            };
            Saver.SaveAsync(Pend);
        }

        private void button4_Click(object sender, EventArgs e)
        {
            Drawer?.Tmr?.Stop();
        }

        private void userManualToolStripMenuItem_Click_1(object sender, EventArgs e)
        {
            System.Diagnostics.Process.Start(
                "C:\\Users\\Asus\\Documents\\HelpNDoc\\Output\\chm\\Pendulum.chm");
        }

        private void button5_Click(object sender, EventArgs e)
        {
            Drawer?.Tmr?.Start();
        }

        private void aboutToolStripMenuItem_Click(object sender, EventArgs e)
        {
            System.Diagnostics.Process.Start(
                "C:\\Users\\Asus\\Documents\\HelpNDoc\\Output\\chm\\Pendulum.chm");
        }


        private void Form1_Load(object sender, EventArgs e)
        {
            // 
            // button6
            // 
            button6.Visible = true;
            button6.Font = new System.Drawing.Font("Times New Roman", 25.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            button6.Location = new System.Drawing.Point(630, 320);
            button6.Name = "button6";
            button6.Size = new System.Drawing.Size(170, 64);
            button6.TabIndex = 18;
            button6.Text = "Quit";
            button6.UseVisualStyleBackColor = true;
            button6.Click += (r, t) => { Application.Exit(); };
            // 
            // pictureBox1
            // 
            pictureBox1.BackColor = System.Drawing.SystemColors.ActiveCaption;
            pictureBox1.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            pictureBox1.Location = new System.Drawing.Point(12, 31);
            pictureBox1.Name = "pictureBox1";
            pictureBox1.Size = new System.Drawing.Size(800, 360);
            pictureBox1.TabIndex = 0;
            pictureBox1.TabStop = false;
            ((System.ComponentModel.ISupportInitialize)(pictureBox1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(pictureBox1)).EndInit();
            // 
            // button1
            // 
            button1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(192)))), ((int)(((byte)(255)))), ((int)(((byte)(192)))));
            button1.Font = new System.Drawing.Font("Times New Roman", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            button1.Location = new System.Drawing.Point(834, 186);
            button1.Name = "button1";
            button1.Size = new System.Drawing.Size(253, 39);
            button1.TabIndex = 1;
            button1.Text = "Oscillate from scratch";
            button1.UseVisualStyleBackColor = false;
            button1.Click += new System.EventHandler(button1_Click_1);
            // 
            // textBox1
            // 
            textBox1.Font = new System.Drawing.Font("Times New Roman", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            textBox1.Location = new System.Drawing.Point(987, 36);
            textBox1.Name = "textBox1";
            textBox1.Size = new System.Drawing.Size(100, 34);
            textBox1.TabIndex = 2;
            textBox1.Text = "1";
            // 
            // textBox2
            // 
            textBox2.Font = new System.Drawing.Font("Times New Roman", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            textBox2.Location = new System.Drawing.Point(987, 89);
            textBox2.Name = "textBox2";
            textBox2.Size = new System.Drawing.Size(100, 34);
            textBox2.TabIndex = 3;
            textBox2.Text = "0,3";
            // 
            // textBox3
            // 
            textBox3.Font = new System.Drawing.Font("Times New Roman", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            textBox3.Location = new System.Drawing.Point(987, 142);
            textBox3.Name = "textBox3";
            textBox3.Size = new System.Drawing.Size(100, 34);
            textBox3.TabIndex = 4;
            textBox3.Text = "9,8";
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new System.Drawing.Font("Times New Roman", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            label1.Location = new System.Drawing.Point(834, 39);
            label1.Name = "label1";
            label1.Size = new System.Drawing.Size(92, 27);
            label1.TabIndex = 5;
            label1.Text = "Length :";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new System.Drawing.Font("Times New Roman", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            label2.Location = new System.Drawing.Point(834, 92);
            label2.Name = "label2";
            label2.Size = new System.Drawing.Size(125, 27);
            label2.TabIndex = 6;
            label2.Text = "Amplitude :";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Font = new System.Drawing.Font("Times New Roman", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            label3.Location = new System.Drawing.Point(834, 145);
            label3.Name = "label3";
            label3.Size = new System.Drawing.Size(147, 27);
            label3.TabIndex = 7;
            label3.Text = "Acceleration :";
            // 
            // menuStrip1
            // 
            menuStrip1.ImageScalingSize = new System.Drawing.Size(20, 20);
            menuStrip1.Items.AddRange(new ToolStripItem[] {
            helpToolStripMenuItem,
            aboutToolStripMenuItem});
            menuStrip1.Location = new System.Drawing.Point(0, 0);
            menuStrip1.Name = "menuStrip1";
            menuStrip1.Size = new System.Drawing.Size(1095, 28);
            menuStrip1.TabIndex = 8;
            menuStrip1.Text = "menuStrip1";
            menuStrip1.ResumeLayout(false);
            menuStrip1.PerformLayout();
            menuStrip1.SuspendLayout();

            // 
            // helpToolStripMenuItem
            // 
            helpToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            userManualToolStripMenuItem});
            helpToolStripMenuItem.Name = "helpToolStripMenuItem";
            helpToolStripMenuItem.Size = new System.Drawing.Size(55, 24);
            helpToolStripMenuItem.Text = "Help";
            // 
            // userManualToolStripMenuItem
            // 
            userManualToolStripMenuItem.Name = "userManualToolStripMenuItem";
            userManualToolStripMenuItem.Size = new System.Drawing.Size(174, 26);
            userManualToolStripMenuItem.Text = "User manual";
            userManualToolStripMenuItem.Click += new System.EventHandler(userManualToolStripMenuItem_Click_1);
            
            // 
            // button2
            // 
            button2.Enabled = false;
            button2.Font = new System.Drawing.Font("Times New Roman", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            button2.Location = new System.Drawing.Point(834, 305);
            button2.Name = "button2";
            button2.Size = new System.Drawing.Size(253, 33);
            button2.TabIndex = 9;
            button2.Text = "Save to word";
            button2.UseVisualStyleBackColor = true;
            button2.Click += new System.EventHandler(button2_Click);
            // 
            // button3
            // 
            button3.Enabled = false;
            button3.Font = new System.Drawing.Font("Times New Roman", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            button3.Location = new System.Drawing.Point(834, 353);
            button3.Name = "button3";
            button3.Size = new System.Drawing.Size(253, 33);
            button3.TabIndex = 10;
            button3.Text = "Save to excel";
            button3.UseVisualStyleBackColor = true;
            button3.Click += new System.EventHandler(button3_Click);
            // 
            // button4
            // 
            button4.BackColor = System.Drawing.Color.Red;
            button4.Font = new System.Drawing.Font("Times New Roman", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            button4.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            button4.Location = new System.Drawing.Point(834, 244);
            button4.Name = "button4";
            button4.Size = new System.Drawing.Size(130, 37);
            button4.TabIndex = 11;
            button4.Text = "Stop";
            button4.UseVisualStyleBackColor = false;
            button4.Click += new System.EventHandler(button4_Click);
            // 
            // button5
            // 
            button5.BackColor = System.Drawing.Color.Lime;
            button5.Font = new System.Drawing.Font("Times New Roman", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            button5.Location = new System.Drawing.Point(970, 244);
            button5.Name = "button5";
            button5.Size = new System.Drawing.Size(117, 37);
            button5.TabIndex = 12;
            button5.Text = "Continue";
            button5.UseVisualStyleBackColor = false;
            button5.Click += new System.EventHandler(button5_Click);
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Font = new System.Drawing.Font("Times New Roman", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            label4.Location = new System.Drawing.Point(12, 398);
            label4.Name = "label4";
            label4.Size = new System.Drawing.Size(176, 27);
            label4.TabIndex = 13;
            label4.Text = "Period (second) :";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Font = new System.Drawing.Font("Times New Roman", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            label5.Location = new System.Drawing.Point(203, 398);
            label5.Name = "label5";
            label5.Size = new System.Drawing.Size(0, 27);
            label5.TabIndex = 14;
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Font = new System.Drawing.Font("Times New Roman", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            label6.Location = new System.Drawing.Point(12, 441);
            label6.Name = "label6";
            label6.Size = new System.Drawing.Size(184, 27);
            label6.TabIndex = 15;
            label6.Text = "Deviation (metr) :";
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Font = new System.Drawing.Font("Times New Roman", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            label7.Location = new System.Drawing.Point(203, 441);
            label7.Name = "label7";
            label7.Size = new System.Drawing.Size(0, 27);
            label7.TabIndex = 16;
            // 
            // richTextBox1
            // 
            richTextBox1.BackColor = System.Drawing.Color.PeachPuff;
            richTextBox1.Font = new System.Drawing.Font("Times New Roman", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            richTextBox1.Location = new System.Drawing.Point(297, 395);
            richTextBox1.Name = "richTextBox1";
            richTextBox1.ScrollBars = System.Windows.Forms.RichTextBoxScrollBars.Vertical;
            richTextBox1.Size = new System.Drawing.Size(531, 75);
            richTextBox1.TabIndex = 17;
            richTextBox1.Text = "";

          
            Controls.Add(richTextBox1);
            Controls.Add(label7);
            Controls.Add(label6);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(button5);
            Controls.Add(button4);
            Controls.Add(button3);
            Controls.Add(button2);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(textBox3);
            Controls.Add(textBox2);
            Controls.Add(textBox1);
            Controls.Add(button1);
            Controls.Add(button6);
            Controls.Add(menuStrip1);
            Controls.Add(pictureBox1);
        }
    }
}
